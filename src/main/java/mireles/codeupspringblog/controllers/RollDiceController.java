package mireles.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showDiceOptions() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guessedNum}")
    public String rollDice(@PathVariable int guessedNum, Model model) {
        List<Integer> rolls = generateRolls();

        model.addAttribute("rolledDice", rolls);
        model.addAttribute("guessedNum", guessedNum);
        model.addAttribute("result", checkGuess(guessedNum, rolls));

        return "roll-dice-result";
    }

    static List<Integer> generateRolls() {
        Random random = new Random();
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int roll = random.nextInt(6) + 1;
            rolls.add(roll);
        }
        return rolls;
    }

    static String checkGuess(int guessedNum, List<Integer> rolls) {
        if (rolls.contains(guessedNum)) {
            return "Winner!";
        } else {
            return "Try Again!";
        }
    }
}


