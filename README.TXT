TASK DESCRIPTION:

Requirements.

1. Highly loaded multyuser service for calculation "special coefficients".
2. Unit and integration tests required.
3. JAX-RS implementation required (for example Jersey)
5. Need to handle synchronization of resource access. 

Input data.

Service should work directly with 2 files in file system f1 and f2:
1. Input file (f1) (contains numbers in csv format)
2. File with pre computed data (f2) (contains numbers in csv format)

Resulting service should support 2 methods:
1. Get (v1) - get v1-n result from f2 file(index starts from 0) f2  and improve result in following way:

if (f2[v1] >10 ) 
  then 
       return f2[v1] - 10
  else 
       return f2[v1]  


2. Post (v2,v3,v4) method: 

if ( f1[v3]+v2 ) <10,
then 
      f2[v4] = f1[v3]+v2 +10
      return true;
else 
      f2[v4] = f1[v3]+v2
      return false;

  f2[v4] should be saved in f2 file

Result should be returned in xml format. Input parameters should be encoded in url.


SOLUTION COMMENTS.

Implemented solution support full consistency on read and write, by locking each individual item.
Probably each-item-locking strategy not the best idea for performance, could be improved by moving to partition based locking mechanism  Sure it also dedens on how much eventual consistency we could allow our self to have, so we could possible could remove synchronization during get().

To run:

         mvn jetty:run

http://localhost:8080/calc/

To execute integration tests:

          mvn clean install -Pitest
 
To stop:
           
          mvn jetty:stop



