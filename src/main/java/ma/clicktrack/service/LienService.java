package ma.clicktrack.service;

import ma.clicktrack.model.Lien;
import java.util.List;

public interface LienService {
    List<Lien> getPublisherLinks(Long publisherId);
    Lien getLienByValue(String lien);
    Lien getLienById(Long id);
    Lien saveLien(Lien lien);
    Lien create(Long publisherId, String destinationUrl);
}
