# language: es

Característica: Crear Grupo para repartir gastos

  Regla: Los grupos están compuestos por al menos dos miembros

    Escenario: No puedo crear un grupo con un único miembro
      Cuando el usuario intenta crear un grupo indicando un único miembro
      Entonces no debería crear el grupo con un único miembro

  Regla: Verificar que el nombre del grupo es único

    Escenario: El nombre del grupo debe ser único
      Cuando un grupo crea como nombre "Inti"
      Y se verifica si el nombre no pertenece a otro grupo
      Entonces el nombre del grupo es aceptado

    Escenario: El nombre del grupo le pertenece a otro grupo
      Dado existe un grupo con el nombre "Inti"
      Cuando un grupo intenta crear como nombre "Inti"
      Entonces el nombre del grupo no es aceptado

    Escenario: El nombre del grupo es similar a otro
      Dado otro grupo crea como nombre "InTi"
      Cuando se verifica si el nombre es similar a otro grupo
      Entonces el nombre del grupo es rechazado