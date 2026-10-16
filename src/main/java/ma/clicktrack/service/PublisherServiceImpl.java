package ma.clicktrack.service;

import ma.clicktrack.model.Publisher;
import ma.clicktrack.repository.PublisherRepository;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    @Override
    public Publisher save(Publisher publisher){
        return publisherRepository.save(publisher);
    }
}
