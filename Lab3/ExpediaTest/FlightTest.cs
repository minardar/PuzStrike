using System;
using Expedia;
using NUnit.Framework;

namespace ExpediaTest
{
	[TestFixture()]
	public class FlightTest
	{
        private readonly DateTime date1 = new DateTime(2009, 2, 20, 5, 45, 0);
        private readonly DateTime date2 = new DateTime(2009, 2, 21, 5, 45, 0);
        private readonly DateTime date6 = new DateTime(2009, 2, 25, 5, 45, 0);
        private readonly DateTime date9 = new DateTime(2009, 2, 28, 5, 45, 0);

        [Test()]
        public void TestThatFlightInitializes()
        {
            var target = new Flight(date1, date2, 5);
            Assert.IsNotNull(target);
        }
        [Test()]
        public void TestThatFlightHasCorrectBasePriceForOneDayFlight()
        {
            var target = new Flight(date1, date2, 5);
            Assert.AreEqual(220, target.getBasePrice());
        }
        [Test()]
        public void TestThatFlightHasCorrectBasePriceForFiveDayFlight()
        {
            var target = new Flight(date1, date6, 5);
            Assert.AreEqual(300, target.getBasePrice());
        }
        [Test()]
        public void TestThatFlightHasCorrectBasePriceForEightDaysFlight()
        {
            var target = new Flight(date1, date9, 5);
            Assert.AreEqual(360, target.getBasePrice());
        }
        [Test()]
        public void TestThatIdenticalFlightsAreEqual()
        {
            var target = new Flight(date1, date9, 5);
            var target2 = new Flight(date1, date9, 5);
            Assert.AreEqual(target2, target);
        }
        [Test()]
        public void TestThatDifferentFlightsAreNotEqual()
        {
            var target = new Flight(date1, date9, 5);
            var target2 = new Flight(date1, date2, 5);
            Assert.AreNotEqual(target2, target);
        }
        [Test()]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void TestThatFlightThrowsOnBadMiles()
        {
            new Flight(date1, date2, -5);
        }
        [Test()]
        [ExpectedException(typeof(InvalidOperationException))]
        public void TestThatFlightThrowsOnBadDates()
        {
            new Flight(date2, date1, 5);
        }
	}
}
