function changeImage(id) {
	let imagePath = document.getElementById(id).getAttribute('src');
	document.getElementById('img-main').setAttribute('src', imagePath);
}