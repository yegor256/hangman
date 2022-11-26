namespace HangmanGame.Letter
{
    public interface ILetter
    {
        char Value();
        char Print();
        bool Hidden();
        ILetter Open(char guess);
    }
}
