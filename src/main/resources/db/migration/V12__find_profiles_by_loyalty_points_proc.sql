DELIMITER $$

CREATE PROCEDURE findProfiles(
    IN loyaltyPoints NUMERIC
)
BEGIN
    SELECT u.*
    FROM users u
             JOIN profiles p ON u.id = p.id
    WHERE p.loyalty_points > loyaltyPoints
    ORDER BY u.email;
END $$

DELIMITER ;
