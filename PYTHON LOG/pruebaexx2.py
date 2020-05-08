def divide():
	while True:
		try:
			opc1=(float(input("Primer numero : ")))
			opc2=(float(input("Primer numero : ")))
			break
		except ValueError:
			print("Valores no numericos")
		except ZeroDivisionError:
			print("Division entre CERO")

	print("La division : ",opc1," / ",opc2," es ",(opc1/opc2),"\n FIN PROGRAMA")

divide()