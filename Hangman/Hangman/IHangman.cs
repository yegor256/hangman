namespace HangmanGame.Hangman
{
    public interface IHangman
    {
        IHangman Step(char guess);
        string Tell();
        bool CanPlay();
    }
}
