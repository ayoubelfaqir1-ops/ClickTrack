package ma.clicktrack.repository;

import ma.clicktrack.model.Lien;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLienRepository implements LienRepository {
    private List<Lien> liens = new ArrayList<>();

    public InMemoryLienRepository() {
    }

    @Override
    public List<Lien> getPublisherLinks(Long id) {
        if (id == null) return new ArrayList<>();
        return liens.stream()
                .filter(l -> l.getPublisherId() != null && l.getPublisherId().equals(id))
                .toList();
    }

    @Override
    public Lien findById(Long id) {
        return liens.stream()
                .filter(l -> l.getId() != null && l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Lien findByLien(String lienValue) {
        return liens.stream()
                .filter(l -> l.getLien() != null && l.getLien().equals(lienValue))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Lien save(Lien lien) {
        if (lien.getId() == null) {
            Long nextId = liens.stream()
                    .mapToLong(Lien::getId)
                    .max()
                    .orElse(0L) + 1;
            lien.setId(nextId);
        }
        liens.add(lien);
        return lien;
    }
}
