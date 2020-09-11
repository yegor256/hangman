using HangmanGame.Hangman;

namespace HangmanGame.GuessStep
{
    internal interface IGuessStep
    {
        IHangman Visit(IStepAcceptor hangman);
    }
}
