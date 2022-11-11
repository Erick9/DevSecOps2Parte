pin = "0"
intentos = 0;

def cajero():
    saldo = 1000
    uno = "\n- Consulta Saldo"
    dos = "\n- Retirar Saldo"
    historico = ""

    while saldo >= 0:
        if saldo == 0:
            op = int(input("No se cuenta con fondos suficientes\n1 = Continuar\n2 = Salir\n"))
            if op == 2:
                saldo = -10
        else:
            opcion = str(input("\nBienvenido Erick Duran\n1 = Consulta Saldo\n2 = Retirar Saldo\n3 = Historico de movimientos\n4 = Salir"))
            if opcion == "1":
                print("1.------Tu saldo actual es: ", saldo)
                historico += uno
            elif opcion == "2":
                retiro = int(input("2.------Cantidad a retirar: "))
                if retiro > saldo:
                    print("No cuenta con saldo suficiente para retirar")
                else:
                    saldo = saldo - retiro
                historico += dos
            elif opcion == "3":
                print("\n2.------Movimientos")
                print(historico)
            elif opcion == "4":
                saldo = -1
            else:
                print("Opcion no valida")


while intentos < 3:
    print("Bienvenido")
    pin = str(input("Ingrese PIN:\n"))
    if pin == "1235":
        cajero()
        intentos = 3
    else:
        intentos = intentos + 1

print("\nHasta pronto")