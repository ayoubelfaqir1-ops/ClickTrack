package ma.clicktrack.repository;

import ma.clicktrack.model.Lien;

import java.util.List;

public interface LienRepository {
    public Lien save(Lien lien);
    public List<Lien> getPublisherLinks(Long id);
    public Lien findByLien(String lien);
    public Lien findById(Long id);
}
