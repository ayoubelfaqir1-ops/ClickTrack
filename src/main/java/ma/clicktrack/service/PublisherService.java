package ma.clicktrack.service;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;

import java.util.List;

public interface PublisherService {
    public List<Publisher> getAllPublishers();
    public Publisher save(Publisher publisher);
}
