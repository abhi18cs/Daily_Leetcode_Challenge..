select p.product_name ,s.year,s.price From Sales s Left join Product p on s.product_id=p.product_id;