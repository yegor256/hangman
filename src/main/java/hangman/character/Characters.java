package character;

import java.util.List;
import java.lang.Character;
import java.util.ArrayList;

/**
 * Providing a list of characters from a string.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Characters implements CharactersList {
        private final String string;

        public Characters(final String string) {
                this.string = string;
        }

        @Override
        public List<Character> list() {
                List<Character> characters = new ArrayList<>();
                for(Character character: string.toCharArray()) {
                        characters.add(character);
                }
                return characters;
        }
}
