package ma.clicktrack.dto;

import ma.clicktrack.model.Categorie;
import ma.clicktrack.model.Publisher;

public record PublisherResponseDto(
        Long id,
        String name,
        String prenom,
        String email,
        Categorie categorie
) {
    public static PublisherResponseDto from(Publisher publisher) {
        if (publisher == null) {
            return null;
        }
        return new PublisherResponseDto(
                publisher.getId(),
                publisher.getName(),
                publisher.getPrenom(),
                publisher.getEmail(),
                publisher.getCategorie()
        );
    }
}
