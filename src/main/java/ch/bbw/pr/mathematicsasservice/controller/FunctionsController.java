package ch.bbw.pr.mathematicsasservice.controller;

import ch.bbw.pr.mathematicsasservice.functions.Functions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Rest Controller
 *
 * @author Peter Rutschmann
 * @version 11.06.2023
 */
@RestController
@RequestMapping("/api")
public class FunctionsController {
    private Functions functions = new Functions();

    @GetMapping(path = "flyingTime")
    public ResponseEntity<String> callFlyingTime(@RequestParam int v0, @RequestParam int theta) {
        Map<String, Object> response = new HashMap<>();
        response.put("function", "flyingTime");
        response.put("v0", v0);
        response.put("theta", theta);
        response.put("result", functions.flyingTime(v0, theta));
        return ResponseEntity.ok().body(response.toString());
    }

    @GetMapping(path = "flyingHeight")
    public ResponseEntity<String> callFlyingHeight(@RequestParam int v0, @RequestParam int theta) {
        Map<String, Object> response = new HashMap<>();
        response.put("function", "flyingTime");
        response.put("v0", v0);
        response.put("theta", theta);
        response.put("result", functions.flyingHeight(v0, theta));
        return ResponseEntity.ok().body(response.toString());
    }

    @GetMapping(path = "flyingWidth")
    public ResponseEntity<String> callFlyingWidth(@RequestParam int v0, @RequestParam int theta) {
        Map<String, Object> response = new HashMap<>();
        response.put("function", "flyingWidth");
        response.put("v0", v0);
        response.put("theta", theta);
        response.put("result", functions.flyingWidth(v0, theta));
        return ResponseEntity.ok().body(response.toString());
    }

    @GetMapping(path = "unsafeAddition")
    public ResponseEntity<String> callUnsafeAddition(@RequestParam int a, @RequestParam int b) {
        Map<String, Object> response = new HashMap<>();
        response.put("function", "unsafeAddition");
        response.put("a", a);
        response.put("b", b);
        response.put("result", functions.unsafeAddition(a, b));
        return ResponseEntity.ok().body(response.toString());
    }

    @GetMapping(path = "safeAddition")
    public ResponseEntity<String> callSafeAddition(@RequestParam int a, @RequestParam int b) {
        Map<String, Object> response = new HashMap<>();
        int result = 0;
        try {
            response.put("function", "safeAddition");
            response.put("a", a);
            response.put("b", b);
            response.put("result", functions.safeAddition(a, b));
        } catch (ArithmeticException e) {
            e.getMessage();
            response.put("function", "safeAddition");
            response.put("a", a);
            response.put("b", b);
            response.put("result", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.toString());
        }
        return ResponseEntity.ok().body(response.toString());
    }

}
