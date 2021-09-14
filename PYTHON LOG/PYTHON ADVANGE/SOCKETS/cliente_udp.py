import socket

class UDPclient:
	def __init__(self,a,p):
		self.ad=a
		self.port=p
	def job(self):
		try:
			sock=socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
			server_add=(self.ad,self.port)
			messages=[b'hello! what is your name?',b'jerecho',b'maria',b'notamgra']
			for message in messages:
				sent= sock.sendto(message,server_add)
				data,server=sock.recvfrom(4096)
				print(data)
		finally:
			print ('closing socket')
			sock.close()

def main():
	cli_obj=UDPclient('192.168.0.14',5000)
	cli_obj.job()
	
if __name__=='__main__':
	main()