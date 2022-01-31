const searchBar = document.querySelector(".search-bar");
const searchBtn = document.querySelector("#search-btn");

const listBtn = document.querySelector("#list-btn");

searchBtn.addEventListener("click", () => {
    let url = `http://localhost:8080/name/${searchBar.value}`;
    fetch(url)
        .then((res) => res.json())
        .then((data) => displayCountry(data));
});

listBtn.addEventListener("click", () => {
    let url = `http://localhost:8080/countries`;
    fetch(url)
        .then((res) => res.json())
        .then((data) => displayCountry(data));
});



const displayCountry = (data) => {
    console.log(data);
    var info = "";
    data.forEach((country, index) => {
        info+="<tr>";
        info+="<td>"+ index +"</td>";
        info+="<td>"+country.name+"</td>";
        info+="<td class='pr-5'>"+country.capital+"</td>";
        info+="<td class='pr-5'>"+country.region+"</td>";
        info+="<td class='pr-5'>"+country.subregion+"</td>";
        info+="<td class='pr-5'>"+country.alpha2Code+"</td>";
        info+="<td class='pr-5'>"+country.population+"</td>";
        info+="<td>"+country.area+"</td>";
	info+="<td><ol>";
	for(i in country.borders){
		info += "<li>" + country.borders[i] +  "</li>"	
	}
	info+="</ol></td>";	
        info+="<td><img src='"+country.flag+"' style='height:80px'></td>";
        info+="</tr>"
    });
    document.getElementById("result").innerHTML=info;
};

