import socket
class UDPserver:
	def __init__(self,h,p):
		self.host=h
		self.port=p
	def job(self):	
		sock=socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
		server_add=(self.host,self.port)
		sock.bind(server_add)
		while True:
			print('waitiing for message.....')						
			data,address=sock.recvfrom(4096)
			if data:
				sent=sock.sendto(data,address)
				print(data,sent,address)
			else:
				print('done')
				break
			
def main():
	udp_obj=UDPserver('192.168.0.14',5000)
	udp_obj.job()
	

if __name__=='__main__':
	main()	