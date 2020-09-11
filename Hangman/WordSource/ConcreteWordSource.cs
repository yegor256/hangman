namespace HangmanGame.WordSource
{
    public class ConcreteWordSource : IWordSource
    {
        private readonly string _word;

        public ConcreteWordSource(string word)
        {
            _word = word;
        }

        public string Load()
        {
            return _word;
        }
    }
}
