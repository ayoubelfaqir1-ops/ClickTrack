package ma.clicktrack.initializer;

import ma.clicktrack.model.Categorie;
import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import ma.clicktrack.service.LienService;
import ma.clicktrack.service.PublisherService;

public class DataInitializer {

    private final PublisherService publisherService;
    private final LienService lienService;

    public DataInitializer(PublisherService publisherService , LienService lienService) {
        this.publisherService = publisherService;
        this.lienService = lienService;
    }

    public void initData() {
        System.out.println("[DEBUG_LOG] Initializing data...");
        try {
            Publisher p1 = new Publisher(1L, "Alami", "Sara", "sara.alami@example.com", Categorie.INFLUENCEUR);
            Publisher p2 = new Publisher(2L, "Bennani", "Youssef", "youssef.bennani@example.com", Categorie.YOUTUBEUR);
            Publisher p3 = new Publisher(3L, "El Idrissi", "Imane", "imane.elidrissi@example.com", Categorie.BLOGUEUR);

            publisherService.save(p1);
            publisherService.save(p2);
            publisherService.save(p3);

            Lien lien1 = new Lien(1L, "/t/1", "https://dest1.com", "Alami", 1L, "Offre 1", 0L);
            Lien lien2 = new Lien(2L, "/t/2", "https://dest2.com", "Bennani", 1L, "Offre 2", 0L);
            Lien lien3 = new Lien(3L, "/t/3", "https://dest3.com", "El Idrissi", 1L, "Offre 3", 0L);

            lienService.saveLien(lien1);
            lienService.saveLien(lien2);
            lienService.saveLien(lien3);
            System.out.println("[DEBUG_LOG] Data initialization complete.");
        } catch (Exception e) {
            System.err.println("[DEBUG_LOG] Error during data initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}