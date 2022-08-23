## Tarea - Distancia de Levenshtein
La distancia de Levenshtein es un algoritmo que permite medir la "distancia" entre dos strings. Esto lo hace contando el número de operaciones necesarias para transformas un string en otro.

Las operaciones que considera son:
- reemplazar un caracter
- eliminar un caracter
- instertar un caracter

Es interesante notar que puede haber muchas combinaciones de las operaciones anteriores que transformen una cadena en la otra. Sin embagro, el algoritmo regresa el mínimo de dichas operaciones. Para hacer las distintas combinaciones de operaciones el algoritmo se llama recursivamente cambiando los parámetros dependiendo de la operaciones que se vaya a realizar. 

Para probarlo, tome varias parejas de dos strings que se parecieran y compriobé que el resultado fuera correcto.
