<?php

include("ayar.php");

$maincategoryandkullaniciid=$_POST['tabload'];
$subcategoryandsubsubcategory=$_POST['kosul'];

$kullaniciid=substr($maincategoryandkullaniciid,0,strpos($maincategoryandkullaniciid,"-"));
$maincategory=substr($maincategoryandkullaniciid,strpos($maincategoryandkullaniciid,"-")+1,strlen($maincategoryandkullaniciid));

$subcategory=substr($subcategoryandsubsubcategory,0,strpos($subcategoryandsubsubcategory,"-"));
$subsubcategory=substr($subcategoryandsubsubcategory,strpos($subcategoryandsubsubcategory,"-")+1,strlen($subcategoryandsubsubcategory));


if($maincategory=="yok") $qry="SELECT * FROM products where Status=1";
else if($subcategory=="yok") $qry="SELECT * FROM products where MainCategoryId='$maincategory' and Status=1";
else if($subsubcategory=="yok") $qry="SELECT * FROM products where MainCategoryId='$maincategory' and SubCategoryId='$subcategory' and Status=1";
else $qry="SELECT * FROM products where MainCategoryId='$maincategory' and SubCategoryId='$subcategory' and SubSubCategoryId='$subsubcategory' and Status=1";	
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$id=$row["StockCode"];
			$query2=mysql_query("Select ImagePath as resim from productsimages where ProductStokCode='$id' and Status=1");
			$oku=mysql_fetch_assoc($query2);
			$resim=array("resim"=>$oku["resim"]);
			$query2=mysql_query("SELECT COUNT(*) AS satir,AVG(Points) AS toplam FROM comments where ProductStockCode='$id' and Status=1");
			$oku=mysql_fetch_assoc($query2);
			if(@is_null($oku["satir"])) $comment=array("Comment"=>"0");
			else $comment=array("Comment"=>$oku["satir"]);
			if(@is_null($oku["toplam"])) $rating=array("Rating"=>"0");
			else $rating=array("Rating"=>$oku["toplam"]);
			if(mysql_num_rows(mysql_query("SELECT * FROM wishlist WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$id' AND WishListStatus=1"))>0)
			{
				$favorites=array("Favorites"=>"1");
			}else{
				$favorites=array("Favorites"=>"0");
			}
			$sonuc=array_merge($resim,$row,$comment,$rating,$favorites);
			$flag[]=$sonuc;
		}
	}
	if(@is_null($flag)) $flag=array("Veri"=>"Yok");
print(json_encode($flag));
mysql_close();
?>