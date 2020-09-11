using HangmanGame.Letter;
using HangmanGame.WordSource;
using System.Linq;

namespace HangmanGame.Letters
{
    public class InitialLetters : ILetters
    {
        private readonly IWordSource _source;

        public InitialLetters(IWordSource source)
        {
            _source = source;
        }

        public ILetter[] Show()
        {
            return _source.Load().Select(x => new HiddenLetter(x)).ToArray();
        }

        public int HiddensCount()
        {
            return Show().Length;
        }
    }
}
