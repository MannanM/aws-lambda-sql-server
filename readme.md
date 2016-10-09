# Connecting to SQL Server from AWS Lambda

AWS Lambda is great, but I had many difficulties finding a way to connect into my RDS SQL Server instance. I started with Python and ODBC (both pyodbc and pypyodbc), but ran into so many issues with missing libraries (LD_LIBRARY_PATH of death).

I turned to Java, but I think SQL Server and Java are a bit like oil and water, so there wasn’t any one place to turn to. Instead I pieced together lots of bits of information and collated it together, into what I think is a pretty compact but extendable project.

Read the step-by-step tutorial on [Mannan Live](http://mannanlive.com/accessing-sql-server-in-aws-lambda-part-1/).