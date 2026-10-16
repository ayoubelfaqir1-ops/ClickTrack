package ma.clicktrack.service;

import ma.clicktrack.dto.OffreResponseDto;
import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import ma.clicktrack.repository.LienRepository;
import ma.clicktrack.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LienServiceImpl implements LienService {
    private final LienRepository lienRepository;
    private final PublisherRepository publisherRepository;

    public LienServiceImpl(LienRepository lienRepository, PublisherRepository publisherRepository) {
        this.lienRepository = lienRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Lien> getPublisherLinks(Long publisherId) {
        return lienRepository.getPublisherLinks(publisherId);
    }

    @Override
    public Lien getLienByValue(String lien) {
        return lienRepository.findByLien(lien);
    }

    @Override
    public Lien getLienById(Long id) {
        return lienRepository.findById(id);
    }

    @Override
    public Lien saveLien(Lien lien) {
        return lienRepository.save(lien);
    }

    @Override
    public Lien create(Long publisherId, String destinationUrl, String offre) {
        Publisher publisher = publisherRepository.findById(publisherId);
        if (publisher == null) {
            return null;
        }

        Lien lien = new Lien();
        lien.setDestinationUrl(destinationUrl);
        lien.setPublisherId(publisherId);
        lien.setPublisherFullName(publisher.getName() + " " + publisher.getPrenom());
        lien.setClicks(0L);
        lien.setOffre(offre);

        // Save first to get the auto-generated ID
        Lien savedLien = lienRepository.save(lien);

        // Update tracking link based on the assigned ID
        savedLien.setLien("/t/" + savedLien.getId());

        return savedLien;
    }

    @Override 
    public Lien IncrementLienClciks(Long id) {
        return lienRepository.ClicksIncrement(id);
    }

    @Override 
    public List<OffreResponseDto> getPublisherOffres(Long id) {
        Publisher publisher = publisherRepository.findById(id);
        if (publisher == null) {
            return null;
        }

        List<Lien> liens = lienRepository.getPublisherLinks(id);
        Map<String, List<Lien>> liensParOffre = liens.stream()
                .collect(Collectors.groupingBy(Lien::getOffre));

        List<OffreResponseDto> offres = new ArrayList<>();
        liensParOffre.forEach((offre, liste) -> {
            long count = (long) liste.size();
            long totalClicks = liste.stream()
                    .mapToLong(l -> l.getClicks() != null ? l.getClicks() : 0L)
                    .sum();
            offres.add(new OffreResponseDto(offre, count, totalClicks));
        });
        return offres;
    }
}
