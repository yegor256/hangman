namespace HangmanGame.Hangman
{
    public class WonHangman : IHangman
    {
        public bool CanPlay()
        {
            return false;
        }

        public string Tell()
        {
            return "You won";
        }

        public IHangman Step(char guess)
        {
            return this;
        }
    }
}
