-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2021 a las 17:57:55
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `unitat6-1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comandes`
--

CREATE TABLE `comandes` (
  `ID` smallint(4) NOT NULL,
  `IDPRODUCTE` smallint(4) NOT NULL,
  `DATACOMANDA` date NOT NULL,
  `QUANTITAT` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comandes`
--

INSERT INTO `comandes` (`ID`, `IDPRODUCTE`, `DATACOMANDA`, `QUANTITAT`) VALUES
(1, 3, '2021-04-22', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producte`
--

CREATE TABLE `producte` (
  `Id` smallint(4) NOT NULL,
  `Descripcio` varchar(50) NOT NULL,
  `STOCKACTUAL` tinyint(3) NOT NULL,
  `STOCKMINIM` tinyint(3) NOT NULL,
  `PVP` float(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producte`
--

INSERT INTO `producte` (`Id`, `Descripcio`, `STOCKACTUAL`, `STOCKMINIM`, `PVP`) VALUES
(1, 'Barcelona, Una biografia', 10, 3, 160.00),
(2, 'La magia de l\'ordre', 5, 2, 176.00),
(3, 'Tot es al teu cap', 6, 5, 193.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendes`
--

CREATE TABLE `vendes` (
  `ID` smallint(4) NOT NULL,
  `IDPRODUCTE` smallint(4) NOT NULL,
  `DATAVENDA` date NOT NULL,
  `QUANTITAT` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendes`
--

INSERT INTO `vendes` (`ID`, `IDPRODUCTE`, `DATAVENDA`, `QUANTITAT`) VALUES
(1, 3, '2021-04-22', 2),
(2, 3, '2021-04-22', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comandes`
--
ALTER TABLE `comandes`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `producte`
--
ALTER TABLE `producte`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `vendes`
--
ALTER TABLE `vendes`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
