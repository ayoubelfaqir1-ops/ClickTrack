package ma.clicktrack.service;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import ma.clicktrack.repository.LienRepository;
import ma.clicktrack.repository.PublisherRepository;

import java.util.List;

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
    public Lien create(Long publisherId, String destinationUrl) {
        Publisher publisher = publisherRepository.findById(publisherId);
        if (publisher == null) {
            return null;
        }

        Lien lien = new Lien();
        lien.setDestinationUrl(destinationUrl);
        lien.setPublisherId(publisherId);
        lien.setPublisherFullName(publisher.getName() + " " + publisher.getPrenom());
        lien.setClicks(0L);
        lien.setOffre("Default Offer");

        // Save first to get the auto-generated ID
        Lien savedLien = lienRepository.save(lien);

        // Update tracking link based on the assigned ID
        savedLien.setLien("/t/" + savedLien.getId());

        return savedLien;
    }
}
