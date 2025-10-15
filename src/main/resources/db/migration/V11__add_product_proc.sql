DELIMITER $$

CREATE PROCEDURE findProductsByPrice(
    minPrice DECIMAL(10, 2),
    maxPrice DECIMAL(10,2)
)
BEGIN
    SELECT id, name, category_id, price from products WHERE price  BETWEEN minPrice AND maxPrice
    ORDER BY name;
end $$

DELIMITER ;