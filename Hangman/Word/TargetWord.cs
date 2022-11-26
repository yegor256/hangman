using HangmanGame.GuessStep;
using HangmanGame.Letter;
using HangmanGame.Letters;
using System.Linq;

namespace HangmanGame.Word
{
    public class TargetWord
    {
        private ILetters _letters;

        public TargetWord(ILetters letters)
        {
            _letters = letters;
        }

        public char[] Print()
        {
            return _letters.Show().Select(x => x.Print()).ToArray();
        }

        internal IGuessStep GuessLetter(char guess)
        {
            int oldHidden = _letters.HiddensCount();
            ILetter[] afterOpen = _letters.Show().Select(x => x.Open(guess)).ToArray();
            _letters = new GuessedLetters(afterOpen);

            if (_letters.HiddensCount() < oldHidden)
            {
                return new SuccessStep();
            }
            else
            {
                return new FailStep();
            }
        }

        public bool Visible()
        {
            return _letters.HiddensCount() == 0;
        }
    }
}
