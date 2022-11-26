using HangmanGame.Letter;

namespace HangmanGame.Letters
{
    public interface ILetters
    {
        ILetter[] Show();
        int HiddensCount();
    }
}
