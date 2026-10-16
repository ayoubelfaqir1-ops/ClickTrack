package ma.clicktrack.repository;

import ma.clicktrack.model.Categorie;
import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPublisherRepository implements PublisherRepository{
    List<Publisher> publishers = new ArrayList<>() ;
    public InMemoryPublisherRepository(){
    }
    @Override
    public List<Publisher> findAll(){
        return publishers;
    };
    @Override
    public List<Lien> getPublisherLinks(Long id){
        return null;
    };
    @Override
    public Lien createLien(String DestinationUrl, Long publisherId){
        return null;
    };
    @Override
    public Publisher save(Publisher publisher){
        publishers.add(publisher);
        return publisher;
    };

    @Override
    public Publisher findById(Long id) {
        return publishers.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
