package hangman;

import view.View;
import word.WordLetters;
import word.WordCondition;
import word.WereLettersOn;
import word.WhereSymbol;
import word.LettersOn;
import word.LettersOnAction;
import game.Failures;
import game.PlayerFailures;
import game.MaxInteger;
import event.OnBase;
import event.IfBase;

/**
 * The player can attempt as many times he can until the number
 * of failures are reached or the success criterion has been
 * achived.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Attempt implements game.Attempt {
        private final View view;
        private final WordLetters word;
        private final MaxInteger maxFailures;
        private final Failures lastFailures;

        public Attempt (final WordLetters word, final MaxInteger maxFailures) {
            this(new WelcomeView(), word, maxFailures);
        }

        public Attempt(final View view, final WordLetters word, 
            final MaxInteger maxFailures) {
                this(view, word, maxFailures, new PlayerFailures());
        }

        public Attempt(final View view, final WordLetters word, 
            final MaxInteger maxFailures, Failures lastFailures) {
                this.view = view;
                this.word = word;
                this.maxFailures = maxFailures;
                this.lastFailures = lastFailures;
        }

        @Override
        public void done() {
                // Test: you hit!
                // WordCondition wordCondition =
                // new WereLettersOn(
                //         new LettersOn(
                //                 new Word(
                //                         new Characters("simplicity")
                //                 ),
                //                 new WhereSymbol('i')
                //         )
                // );

                // Test: you won!
                // WordCondition wordCondition =
                //      new WereLettersOn(
                //              new LettersOn(new WhereSymbol('i'),
                //                      new Word(
                //                              new Characters(
                //                                      "iiii"))));

                // Test: you missed it!
                // WordCondition wordCondition =
                // new WereLettersOn(
                //         new LettersOn(
                //                 new Word(
                //                         new Characters("simplicity")
                //                 ),
                //                 new WhereSymbol('a')
                //         )
                // );
                
                // It requires another level of abstraction:
                //      new Action(new Evaluation(new Result()))
                LettersOnAction updatedWordAction = new LettersOn(word, new WhereSymbol('i'));
                WordCondition wordCondition = new WereLettersOn(updatedWordAction);

                new OnWon(new WonView(),
                        new OnLost(new LostView(),  
                                new OnNewAttempt(new NewAttemptView(
                                                    new MissedView(
                                                        new FailuresMessage(
                                                            maxFailures, 
                                                            lastFailures
                                                        )
                                                    )
                                                ), updatedWordAction, maxFailures, lastFailures,                                        
                                        new OnGuessed(new GuessedView(),
                                                new OnMissed(maxFailures, lastFailures, 
                                                        new OnBase(
                                                                new IfWon(wordCondition, 
                                                                        new IfGuessed(wordCondition,
                                                                                new IfMissed(wordCondition,
                                                                                        new IfBase())))))))))
                .bubbled();                        
        }
}