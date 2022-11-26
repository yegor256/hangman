using HangmanGame.GuessStep;

namespace HangmanGame.Hangman
{
    internal interface IStepAcceptor
    {
        IHangman Accept(SuccessStep step);
        IHangman Accept(FailStep step);
    }
}
