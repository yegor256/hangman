using HangmanGame.Hangman;

namespace HangmanGame.GuessStep
{
    internal class FailStep : IGuessStep
    {
        public IHangman Visit(IStepAcceptor hangman)
        {
            return hangman.Accept(this);
        }
    }
}
