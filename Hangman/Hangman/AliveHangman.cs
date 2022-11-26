using HangmanGame.GuessStep;
using System;
using HangmanGame.Word;

namespace HangmanGame.Hangman
{
    public class AliveHangman : IHangman, IStepAcceptor
    {
        private readonly TargetWord _secret;
        private readonly int _max;
        private readonly int _mistakes;
        private readonly string _message;

        public AliveHangman(TargetWord secret, int max)
        {
            _secret = secret;
            _max = max;
            _message = "Guess a letter: ";
            _mistakes = 0;
        }

        private AliveHangman(TargetWord secret, int max, string message, int mistakes)
        {
            _secret = secret;
            _max = max;
            _mistakes = mistakes;
            _message = message;
        }

        public IHangman Step(char guess)
        {
            IGuessStep step = _secret.GuessLetter(guess);
            return step.Visit(this);
        }

        public bool CanPlay()
        {
            return true;
        }

        public string Tell()
        {
            return _message;
        }

        IHangman IStepAcceptor.Accept(SuccessStep step)
        {
            if (_secret.Visible())
            {
                return new WonHangman();
            }
            else
            {
                string msg = $"Hit! {Environment.NewLine} {string.Join(Environment.NewLine, _secret.Print())}";
                return new AliveHangman(_secret, _max, msg, _mistakes);
            }
        }

        IHangman IStepAcceptor.Accept(FailStep step)
        {
            int mistakes = _mistakes + 1;
            if (mistakes >= _max)
            {
                return new DeadHangman();
            }
            else
            {
                string msg = $"Missed, mistake {mistakes} out of {_max}{Environment.NewLine} {string.Join(Environment.NewLine, _secret.Print())}";
                return new AliveHangman(_secret, _max, msg, mistakes);
            }
        }
    }
}
