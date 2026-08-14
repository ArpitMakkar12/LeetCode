# Write your MySQL query statement below
Select x, y, z, 
    IF(
        x > 0 AND y > 0 AND z > 0 AND
        x + y > z AND
        x + z > y AND 
        y + z > x,
        "Yes",
        "No"
        ) as triangle
From Triangle
