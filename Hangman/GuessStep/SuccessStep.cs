using HangmanGame.Hangman;

namespace HangmanGame.GuessStep
{
    internal class SuccessStep : IGuessStep
    {
        public IHangman Visit(IStepAcceptor hangman)
        {
            return hangman.Accept(this);
        }
    }
}
