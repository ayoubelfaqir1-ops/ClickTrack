package ma.clicktrack.repository;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;

import java.util.List;

public interface PublisherRepository {
    public List<Publisher> findAll();
    public List<Lien> getPublisherLinks(Long id);
    public Lien createLien(String DestinationUrl, Long publisherId);
    public Publisher save(Publisher publisher);
}
