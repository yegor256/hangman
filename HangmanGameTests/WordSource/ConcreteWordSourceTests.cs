using HangmanGameTests;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace HangmanGame.WordSource.Tests
{
    [TestClass()]
    public class ConcreteWordSourceTests
    {
        [TestMethod()]
        public void LoadTest()
        {
            RandomWord rw = new RandomWord(5, 20);
            string test = rw.Word();
            ConcreteWordSource cws = new ConcreteWordSource(test);

            string result = cws.Load();

            Assert.AreEqual(test, result);
        }
    }
}