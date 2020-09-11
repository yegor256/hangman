namespace HangmanGame.Hangman
{
    public class DeadHangman : IHangman
    {
        public bool CanPlay()
        {
            return false;
        }

        public string Tell()
        {
            return "You lost.";
        }

        public IHangman Step(char guess)
        {
            return this;
        }
    }
}
