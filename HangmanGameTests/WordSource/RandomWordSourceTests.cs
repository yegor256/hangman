using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace HangmanGame.WordSource.Tests
{
    [TestClass()]
    public class RandomWordSourceTests
    {
        private readonly string[] _words = { "test", "another", "something", "else" };

        [TestMethod()]
        public void LoadTest()
        {
            RandomWordSource rws = new RandomWordSource(_words, new Random());

            string loaded = rws.Load();

            Assert.AreEqual(loaded, rws.Load());
        }

        [TestMethod()]
        public void ReloadTest()
        {
            RandomWordSource rws = new RandomWordSource(_words, new Random());

            string loaded = rws.Load();
            rws.Reload();
            string reloaded = rws.Load();

            Assert.AreNotEqual(loaded, reloaded);
        }
    }
}