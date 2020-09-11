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
    public class DeadHangmanTests
    {
        [TestMethod()]
        public void CanPlayTest()
        {
            DeadHangman hangman = new DeadHangman();

            Assert.IsFalse(hangman.CanPlay());
        }

        [TestMethod()]
        public void TellTest()
        {
            DeadHangman hangman = new DeadHangman();

            string msg = hangman.Tell();

            Assert.AreEqual(msg, "You lost.");
        }

        [TestMethod()]
        public void StepTest()
        {
            DeadHangman hangman = new DeadHangman();
            RandomChar rc = new RandomChar();

            IHangman newHangman = hangman.Step(rc.Load());

            Assert.IsInstanceOfType(newHangman, typeof(DeadHangman));
        }
    }
}