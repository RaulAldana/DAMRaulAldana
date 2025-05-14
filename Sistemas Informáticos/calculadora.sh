#!/bin/bash

#Comienzo del script

opcion=0

while [ $opcion -ne 4 ]; do
echo "-----CALCULADORA-----"
echo ""
echo "1 - Sumar"
echo "2 - Restar"
echo "3 - Multiplicar"
echo "4 - Salir"
echo ""

read -p "" opcion

if [ -z $opcion] || [ $opcion -lt 1 ] || [ $opcion -gt 4 ]; then

echo "Debes poner un valor que este sobre la tabla de la calculadora"
read -p ""
clear

fi

if [ $opcion -eq 1 ]; then

read -p "Introduce el valor del primer numero: " num1
read -p "Introduce el valor del segundo numero: " num2
echo""

  if [ -z $num1 ] || [ -z $num2 ]; then
   echo "Debes poner valores razonables"
   echo ""
   exit 0
  fi

resultado=$(($num1+$num2))

echo "El resultado de la suma es: $resultado"
echo ""

fi

if [ $opcion -eq 2 ]; then

read -p "Introduce el valor del primer numero: " num1
read -p "Introduce el valor del segundo numero: " num2
echo ""

  if [ -z $num1 ] || [ -z $num2 ]; then
   echo "Debes poner valores razonables"
   exit 0
  fi

resultado=$(($num1-$num2))

echo "El resultado de la resta es: $resultado"
echo ""

fi

if [ $opcion -eq 3 ]; then

read -p "Introduce el valor del primer numero: " num1
read -p "Introduce el valor del segundo numero: " num2
echo ""

  if [ -z $num1 ] || [ -z $num2 ]; then
   echo "Debes poner valores razonables"
   exit 0
  fi

resultado=$(($num1*$num2))

echo "El resultado de la multiplicacion es: $resultado"
echo ""

fi

if [ $opcion -eq 4 ]; then

echo "Saliendo..."

fi

done
exit 1
