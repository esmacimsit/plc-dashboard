document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('.barcode-svg').forEach(function(svg) {
        const barcodeText = svg.getAttribute('data-barcode');
        const width = 150;
        const height = 40;

        let svgContent = '';

        // Beyaz arkaplan
        svgContent += '<rect width="100%" height="100%" fill="white" stroke="#ddd" stroke-width="1"/>';

        let x = 3;

        // Başlangıç çizgisi
        svgContent += `<rect x="${x}" y="5" width="1" height="25" fill="black"/>`;
        x += 1.5;

        for(let i = 0; i < barcodeText.length; i++) {
            const charCode = barcodeText.charCodeAt(i);
            const patterns = [
                [0.8,0.8,0.8,1.2,0.8,1.2],
                [1.2,0.8,0.8,0.8,0.8,1.2],
                [0.8,0.8,1.2,0.8,0.8,1.2],
                [0.8,0.8,1.2,1.2,0.8,0.8]
            ];
            const pattern = patterns[charCode % patterns.length];

            pattern.forEach((barWidth, index) => {
                if (index % 2 === 0) {
                    svgContent += `<rect x="${x}" y="5" width="${barWidth}" height="25" fill="black"/>`;
                }
                x += barWidth;
            });
            x += 0.3;
        }

        // Bitiş çizgisi
        svgContent += `<rect x="${x}" y="5" width="1" height="25" fill="black"/>`;

        // Barkod numarası
        svgContent += `<text x="${width/2}" y="35" text-anchor="middle" font-family="Courier New" font-size="7" fill="#333">${barcodeText}</text>`;

        svg.innerHTML = svgContent;
    });
});
