using Microsoft.VisualStudio.TestTools.UnitTesting;
using HangmanGame.Hangman;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HangmanGameTests;

namespace HangmanGame.Hangman.Tests
{
    [TestClass()]
    public class WonHangmanTests
    {
        [TestMethod()]
        public void CanPlayTest()
        {
            WonHangman hangman = new WonHangman();

            Assert.IsFalse(hangman.CanPlay());
        }

        [TestMethod()]
        public void TellTest()
        {
            WonHangman hangman = new WonHangman();

            string msg = hangman.Tell();

            Assert.AreEqual(msg, "You won");
        }

        [TestMethod()]
        public void StepTest()
        {
            WonHangman hangman = new WonHangman();
            RandomChar rc = new RandomChar();

            IHangman newHangman = hangman.Step(rc.Load());

            Assert.IsInstanceOfType(newHangman, typeof(WonHangman));
        }
    }
}