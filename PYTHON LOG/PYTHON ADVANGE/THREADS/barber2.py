from threading import Thread, Lock, Event
import time, random

mutex = Lock()

class BarberShop:
	waitingCustomers = []

	def __init__(self, barber, numberOfSeats):
		self.barber = barber
		self.numberOfSeats = numberOfSeats

	def openShop(self):
		print ('Barber shop is opening')
		workingThread = Thread(target = self.barberGoToWork)
		workingThread.start()

	def barberGoToWork(self):
		while True:
			mutex.acquire()
			if len(self.waitingCustomers) > 0:
				c = self.waitingCustomers.pop()
				mutex.release()
				#c.cliente.join()
				self.barber.cutHair(c)
			else:
				mutex.release()
				print ('Aaah, all done, going to sleep')
				barber.sleep()
				print ('Barber woke up')
	
	def enterBarberShop(self, customers):
		while len(customers) > 0:
			c = customers.pop()
			mutex.acquire()
			print ('>> {0} entered the shop and is looking for a seat'.format(c.name))
			if len(self.waitingCustomers) == self.numberOfSeats:
				print ('Waiting room is full, {0} is leaving.'.format(c.name))
				#c.cliente.join()
				mutex.release()
			else:
				print ('{0} sat down in the waiting room'.format(c.name))	
				self.waitingCustomers.append(c)	
				mutex.release()
				barber.wakeUp()
			time.sleep(3)	
		

class Customer:
	def __init__(self, name):
		self.name = name
		self.cliente = Thread()
		#self.cliente.start()

class Barber:
	barberWorkingEvent = Event()

	def sleep(self):
		self.barberWorkingEvent.wait()

	def wakeUp(self):
		self.barberWorkingEvent.set()

	def cutHair(self, customer):
		#Set barber as busy 
		self.barberWorkingEvent.clear()
		print ('{0} is having a haircut'.format(customer.name))
		time.sleep(5)
		#customer.cliente.join()
		print ('{0} is done'.format(customer.name))


if __name__ == '__main__':
	customers = []
	customers.append(Customer('Bragi'))
	customers.append(Customer('Auja'))
	customers.append(Customer('Iris'))
	customers.append(Customer('Axel'))
	customers.append(Customer('Andrea'))
	customers.append(Customer('Agnar'))

	barber = Barber()
	barberShop = BarberShop(barber, numberOfSeats=3)
	barberShop.openShop()
	barberShop.enterBarberShop(customers)