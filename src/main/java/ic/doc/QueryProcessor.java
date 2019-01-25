package ic.doc;

public class QueryProcessor {

    public String process(String query) {
        StringBuilder results = new StringBuilder();
        if (query.toLowerCase().contains("shakespeare")) {
            results.append("William Shakespeare (26 April 1564 - 23 April 1616) was an\n" +
                           "English poet, playwright, and actor, widely regarded as the greatest\n" +
                           "writer in the English language and the world's pre-eminent dramatist. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("asimov")) {
            results.append("Isaac Asimov (2 January 1920 - 6 April 1992) was an\n" +
                           "American writer and professor of Biochemistry, famous for\n" +
                           "his works of hard science fiction and popular science. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("hamilton")) {
            results.append("Hamilton: An American Musical is a sung- and rapped-through musical\n" +
                "about the life of American Founding Father Alexander Hamilton, with music, \n" +
                "lyrics and book by Lin-Manuel Miranda, inspired by the 2004 biography Alexander\n" +
                    "Hamilton by author and historian Ron Chernow. Incorporating hip hop, R&B, pop,\n" +
                    "soul, traditional-style show tunes, and color-conscious casting of non-white actors\n" +
                    "as the Founding Fathers and other historical figures, the musical achieved both\n" +
                    "critical acclaim and box office success.\n");
            results.append(System.lineSeparator());
        }

        if(query.toLowerCase().contains("pacman")) {
            results.append("Pac-man is an arcade game is a Japanese game made in 1980 where the objective the game is to navigates Pac-man\n" +
                    "through a maze containing dots. The goal of the game is to is to accumulate as many points as possible by collecting the dots and eating ghosts.\n" +
                    "The player advances to the next level when all the dots is collected. The four ghosts roam the maze and chase Pac-Man. If Pac-man comes into contact with a ghost, he loses a life.\n" +
                    "The game ends when all lives have been lost.\n" + "\n" + "\n" + "\n" + "\n" +
                    "<a href=https://www.miniclip.com/games/pac-man-io/en/><i>Click here</i></a>" + " to go to the game\n" + "\n" +
                    "Reference: https://en.wikipedia.org/wiki/Pac-Man#Gameplay");
            results.append(System.lineSeparator());

        }

        return results.toString();
    }
}
