SELECT *
FROM Users
WHERE mail REGEXP '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$';

  # mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$';