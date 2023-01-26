package fr.iut.caen.score;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/points")
@Log4j2
public class PointsApi {

    private Integer points = 0;

    @GetMapping(produces = "application/json")
    public Integer getCurrentScore() {
        log.info("Score courant: {}", points);
        return points;
    }

    @PostMapping(produces = "application/json")
    public Integer score() {
        points = points + 1;
        log.info("Point marqué ! Nouveau score: {}", points);
        return points;
    }

    @DeleteMapping()
    public void reset() {
        log.info("Réinitialisation à 0 du score");
        points = 0;
    }
}
